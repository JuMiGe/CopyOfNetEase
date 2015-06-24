package com.jumige.android.common.utils;

import android.app.Service;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.webkit.CookieManager;
import org.apache.http.*;
import org.apache.http.ProtocolException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.DefaultRedirectHandler;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HTTP;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;

import java.io.*;
import java.net.*;
import java.util.List;

public class NetUtil {
	private static int timeoutMillis = 5000;

	/**
	 * 检查网络连接状态
	 * 
	 * @param context
	 * @return
	 */
	public static boolean checkNetwork(Context context) {
        if (context != null){
            ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Service.CONNECTIVITY_SERVICE);
            NetworkInfo netInfo = cm.getActiveNetworkInfo();
            if (netInfo != null && netInfo.isConnected()) {
                return true;
            }
        }

		return false;
	}

	/**
	 * 判断wifi是否打开
	 * 
	 * @param context
	 * @return
	 */
	public static boolean chckWifiState(Context context) {
        if(context==null){
            LayzLog.e("%s", "context is null");
            return false;
        }
		ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Service.CONNECTIVITY_SERVICE);
		if (cm != null) {
			NetworkInfo[] info = cm.getAllNetworkInfo();
			if (info != null) {
				for (int i = 0; i < info.length; i++) {
					if (info[i].getTypeName().equalsIgnoreCase("WIFI") && info[i].isConnected()) {
						return true;
					}
				}
			}
		}
		return false;
	}

	/**
	 * 从指定的url中获取字节数组
	 * 
	 * @param urlPath
	 * @return 字节数组
	 * @throws java.io.IOException
	 * @throws Exception
	 */
	public static byte[] getByte(String urlPath) {
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		byte[] data = new byte[1024];
		byte[] bytes = null;
		int len = 0;

		URL url = null;
		try {
			url = new URL(urlPath);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		HttpURLConnection conn = null;
		InputStream inStream = null;
		try {
			if (url != null) {
				conn = (HttpURLConnection) url.openConnection();
				conn.setConnectTimeout(timeoutMillis);
				inStream = conn.getInputStream();
				while ((len = inStream.read(data)) != -1) {
					outStream.write(data, 0, len);
				}
				bytes = outStream.toByteArray();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.disconnect();
				if (inStream != null)
					inStream.close();
				if (outStream != null)
					outStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return bytes;
	}

	/**
	 * 从指定url获取文本文件的字符串
	 *
	 * @param url
	 * @return
	 * @throws org.apache.http.client.ClientProtocolException
	 * @throws java.io.IOException
	 */
	public static String getString(String url) {
		HttpGet httpRequest = new HttpGet(url);
		DefaultHttpClient httpClient = new DefaultHttpClient();
		HttpParams params = httpClient.getParams();
		HttpConnectionParams.setConnectionTimeout(params, timeoutMillis);
		HttpConnectionParams.setSoTimeout(params, timeoutMillis);

		CookieManager cookieManager = CookieManager.getInstance();
		String cookie = cookieManager.getCookie(url);
		httpRequest.addHeader("Cookie", cookie);

		HttpResponse httpResponse = null;
		String content = null;
		try {
			httpResponse = httpClient.execute(httpRequest);
			if (httpResponse.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
			}
			if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				content = EntityUtils.toString(httpResponse.getEntity(), HTTP.UTF_8);
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			if(!httpRequest.isAborted()){
				httpRequest.abort();
				if(httpResponse != null){
					HttpEntity entity = httpResponse.getEntity();
					if(entity != null){
						try {
							entity.consumeContent();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}

		}
		return content;
	}

	/**
	 * 从指定url获取文本文件的InputStream
	 *
	 * @param url
	 * @return
	 * @throws org.apache.http.client.ClientProtocolException
	 * @throws java.io.IOException
	 */
	public static InputStream getStream(String url) {
		HttpGet httpRequest = new HttpGet(url);
		DefaultHttpClient httpClient = new DefaultHttpClient();
		HttpParams params = httpClient.getParams();
		HttpConnectionParams.setConnectionTimeout(params, timeoutMillis);
		HttpConnectionParams.setSoTimeout(params, timeoutMillis);

		CookieManager cookieManager = CookieManager.getInstance();
		String cookie = cookieManager.getCookie(url);
		httpRequest.addHeader("Cookie", cookie);

		HttpResponse httpResponse = null;
		try {
			httpResponse = httpClient.execute(httpRequest);
			if (httpResponse.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
			}
			if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				return httpResponse.getEntity().getContent();
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
//			if(!httpRequest.isAborted()){
//				httpRequest.abort();
//				if(httpResponse != null){
//					HttpEntity entity = httpResponse.getEntity();
//					if(entity != null){
//						try {
//							entity.consumeContent();
//						} catch (IOException e) {
//							e.printStackTrace();
//						}
//					}
//				}
//
//			}
		}
		return null;
	}

	/**
	 * 将输入流转换为字符串
	 *
	 * @param is
	 * @return
	 */
	public static String convertStreamToString(InputStream is) {

		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		StringBuilder sb = new StringBuilder();

		String line = null;
		try {
			while ((line = reader.readLine()) != null) {
				sb.append((line));
				// sb.append((line + "\n"));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return sb.toString();
	}

	/**
	 * 从指定url获取文本文件的字符串并记录下Cookie
	 *
	 * @param url
	 * @return
	 * @throws java.io.IOException
	 */
	public static String getStringAndCookie(String url) {
		HttpGet httpRequest = new HttpGet(url);
		DefaultHttpClient httpClient = new DefaultHttpClient();
		HttpParams params = httpClient.getParams();
		HttpConnectionParams.setConnectionTimeout(params, timeoutMillis);
		HttpConnectionParams.setSoTimeout(params, timeoutMillis);
		HttpResponse httpResponse = null;
		try {
			// 重写重定向
			httpClient.setRedirectHandler(new DefaultRedirectHandler() {

				@Override
				public URI getLocationURI(HttpResponse response, HttpContext context) throws ProtocolException {
					URI uri = super.getLocationURI(response, context);
					// 保存Cookie
					addCookies(uri.toString(), response);
					return uri;
				}

			});
			httpResponse = httpClient.execute(httpRequest);
			// 保存Cookie
			addCookies(url, httpResponse);
			if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				return EntityUtils.toString(httpResponse.getEntity(), HTTP.UTF_8);
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(!httpRequest.isAborted()){
				httpRequest.abort();
				if(httpResponse != null){
					HttpEntity entity = httpResponse.getEntity();
					if(entity != null){
						try {
							entity.consumeContent();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
		return null;
	}

	/**
	 * 下载文件
	 *
	 * @param downloadUrl
	 * @param saveFile
	 * @return
	 * @throws java.io.IOException
	 */
	public static long downloadFile(String downloadUrl, File saveFile)
			throws IOException {
		long retValue = 0;
		long currentSize = 0;
		int totalSize = 0;
		long updateTotalSize = 0;
		if (!saveFile.getParentFile().exists()) {
			saveFile.getParentFile().mkdirs();
		}
		if (!saveFile.exists()) {
			try {
				saveFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		currentSize = saveFile.length();
		DefaultHttpClient httpClient = new DefaultHttpClient();
		HttpGet httpGet = new HttpGet(downloadUrl);
		httpGet.addHeader("Range", "bytes=" + currentSize + "-");
		CookieManager cookieManager = CookieManager.getInstance();
		String cookie = cookieManager.getCookie(downloadUrl);
		httpGet.addHeader("Cookie", cookie);
		HttpResponse httpResponse = null;

		InputStream httpInputStream = null;
		try {
			httpResponse = httpClient.execute(httpGet);
			HttpEntity httpEntity = httpResponse.getEntity();

			httpInputStream = httpEntity.getContent();
			updateTotalSize = httpEntity.getContentLength();
		} catch (Exception e) {
			e.printStackTrace();
		}
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(saveFile, true);
			byte buffer[] = new byte[4096];
			int readSize = 0;
			totalSize += currentSize;
			while ((readSize = httpInputStream.read(buffer)) > 0) {
				fos.write(buffer, 0, readSize);
				totalSize += readSize;
			}

			if (updateTotalSize == -1) { // 服务器未返回长度
				if (totalSize != currentSize) { // 读取到了数据
					retValue = totalSize;
				} else { // 未读取到数据
					retValue = -3;
				}
			} else if (totalSize == (updateTotalSize + currentSize)) { // 服务器返回了长度，且正确读取到了数据
				retValue = totalSize;
			} else { // 未正确读取到数据
				retValue = -1;
			}
		} catch (Exception e) {
			e.printStackTrace();
			retValue = -2;
		} finally {
			if (httpInputStream != null) {
				httpInputStream.close();
			}
			if (fos != null) {
				fos.close();
			}
		}
		return retValue;
	}

	/**
	 * try download with cookie if failed, try without cookie
	 *
	 * @param url
	 * @param filePath
	 * @return
	 */
	public static boolean downloadCover(String url, String filePath) {
		if (url == null || url.equals(""))
			return false;
		File tempFile = new File(filePath + ".temp");
		File saveFile = new File(filePath);
		if (!saveFile.getParentFile().exists()) {
			saveFile.getParentFile().mkdirs();
		}
		if (!tempFile.exists()) {
			try {
				tempFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			long downloadSize = downloadFile(url, tempFile);
			// if( downloadSize > 0 || downloadSize == -3){ // 下载成功，但用户退出了
			if (downloadSize > 0 && tempFile.length() == downloadSize) {
				tempFile.renameTo(saveFile);
				return true;
			}
			tempFile.delete();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public static String getHostUrl(String url) {
		int end = -1;
		if (url.startsWith("http://"))
			end = url.indexOf("/", 7);
		else if (url.startsWith("https://"))
			end = url.indexOf("/", 8);
		else if (url.startsWith("ftp://"))
			end = url.indexOf("/", 6);
		if (end == -1)
			return url;
		else
			return url.substring(0, end);
	}

	public static String getDomain(String url) {
		int start = 0;
		int end = -1;
		if (url.startsWith("http://")) {
			start = 7;
			end = url.indexOf("/", 7);
		} else if (url.startsWith("https://")) {
			start = 8;
			end = url.indexOf("/", 8);
		} else if (url.startsWith("ftp://")) {
			start = 6;
			end = url.indexOf("/", 6);
		}
		if (end == -1)
			return url.substring(start);
		else
			return url.substring(start, end);
	}

	public static String encodeUrlParamter(String url) {
		int qIndex = url.indexOf('?');
		if (qIndex == -1)
			return url;
		String host = url.substring(0, qIndex + 1);
		String paramStr = url.substring(qIndex + 1);
		String[] params = paramStr.split("&");
		StringBuffer sbUrl = new StringBuffer(host);
		if (params != null)
			for (String param : params) {
				int eIndex = param.indexOf('=');
				String name = param.substring(0, eIndex + 1);
				String value = param.substring(eIndex + 1);
				try {
					sbUrl.append(name).append(URLEncoder.encode(value, "gb2312"));
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}

			}
		return sbUrl.toString();
	}

	public static String encodeParamter(String param, String charsetName, int times)
			throws UnsupportedEncodingException {
		String encodedParam = param;
		for (int i = 0; i < times; i++) {
			encodedParam = URLEncoder.encode(encodedParam, charsetName);
		}
		return encodedParam;
	}

	public static List<NameValuePair> parseUrl(String url) {
		List<NameValuePair> l = null;
		try {
			l = URLEncodedUtils.parse(new URI(url), "utf-8");
		} catch (URISyntaxException e) {
		} catch (IllegalArgumentException e) {
		}
		return l;
	}

	public static String getParam(List<NameValuePair> params, String name) {
		if (params == null) {
			return "";
		}
		for (NameValuePair p : params) {
			if (p.getName().equals(name)) {
				return p.getValue();
			}
		}
		return "";
	}

	public static String getParam(String url, String name) {
		List<NameValuePair> l = parseUrl(url);
		return getParam(l, name);
	}

	/**
	 * 用post方式从指定url获取文本文件的字符串
	 *
	 * @param url
	 * @return
	 * @throws org.apache.http.client.ClientProtocolException
	 * @throws java.io.IOException
	 */
	public static String getStringByPost(String url, List<NameValuePair> nameValuePairs) {
		HttpPost httppost = new HttpPost(url);
		// List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
		// nameValuePairs.add(new BasicNameValuePair("id", "12345"));
		// Your DATA

		try {
			httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		DefaultHttpClient httpClient = new DefaultHttpClient();
		HttpParams params = httpClient.getParams();
		HttpConnectionParams.setConnectionTimeout(params, timeoutMillis);
		HttpConnectionParams.setSoTimeout(params, timeoutMillis);

		CookieManager cookieManager = CookieManager.getInstance();
		String cookie = cookieManager.getCookie(url);
		httppost.addHeader("Cookie", cookie);

		HttpResponse httpResponse;
		try {
			httpResponse = httpClient.execute(httppost);
			if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				return EntityUtils.toString(httpResponse.getEntity());
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
			httppost.abort();
		} catch (IOException e) {
			e.printStackTrace();
			httppost.abort();
		}
		return null;
	}

	public static void addCookies(String url, HttpResponse response) {
		Header[] headers = response.getHeaders("Set-Cookie");
		if (headers != null && headers.length > 0) {
			CookieManager cookieManager = CookieManager.getInstance();
			for (Header h : headers) {
				cookieManager.setCookie(url, h.getValue());
			}
		}
	}
}
