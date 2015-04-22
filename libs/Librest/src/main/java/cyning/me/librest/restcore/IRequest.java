package cyning.me.librest.restcore;

import org.apache.http.Header;

/**
 * Author: cyning
 * Date  : 2015.04.09
 * Time  : 下午5:14
 * Desc  : 类/接口描述
 */
public interface IRequest {





    public void doRequest(final Object tag, RequestType _requestType, final String paramsUrl, final RequestParams params, final Header[] headers, final BaseApiHandler responseHandler);



    public static enum RequestType {
        POST,
        GET,
        DELETE;

    }






}
