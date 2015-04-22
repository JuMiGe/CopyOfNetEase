package cyning.me.librest.restcore;

/**
 * Author: cyning
 * Date  : 2015.04.09
 * Time  : 下午5:45
 * Desc  : 针对请求,返回的Handler
 */
public interface BaseApiHandler {

    /**
     * 开始
     */
    public void onStart();

    /**
     * 结束
     */
    public void onFinish();

    /**
     * 返回成功
     */
    public void onSuccess(String jsonStr);

    /**
     * 返回Server失败
     * <p>表示server端有返回数据，</p>
     */
    public void onServerError();

    public void onClientError();
}
