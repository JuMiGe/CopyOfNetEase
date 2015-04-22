package cyning.me.librest.restcore;

import org.apache.http.Header;

/**
 * Author: cyning
 * Date  : 2015.04.09
 * Time  : 下午6:14
 * Desc  : 访问API的接口
 */
public class AbsApiClient implements IRequest {




    @Override
    public void doRequest(Object tag, RequestType _requestType, String paramsUrl, RequestParams params, Header[] headers, BaseApiHandler responseHandler) {

        if (_requestType == null){
            _requestType = RequestType.GET;
        }
        if (_requestType == RequestType.GET){
           doGet(tag,paramsUrl,params,headers,responseHandler);
        }else if (_requestType == RequestType.POST){
            doPost(tag,paramsUrl,params,headers,responseHandler);
        }

    }

    public void doGet(Object tag, String paramsUrl, RequestParams params, Header[] headers, BaseApiHandler responseHandler) {

    }

    public void doPost(Object tag, String paramsUrl, RequestParams params, Header[] headers, BaseApiHandler responseHandler) {

    }
}
