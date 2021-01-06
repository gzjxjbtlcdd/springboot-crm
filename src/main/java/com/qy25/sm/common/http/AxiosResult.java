package com.qy25.sm.common.http;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
//转json的时候 只转值不为null的
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AxiosResult<T> {
    private int status;
    private String message;
    private T data;

    private AxiosResult(){

    }

    /**
     * 封装数据公共方法
     * @param axiosStatus
     * @param data
     * @param <T>
     * @return
     */
    private static <T> AxiosResult<T> setData(AxiosStatus axiosStatus,T data){
        AxiosResult<T> axiosResult=new AxiosResult<>();
        axiosResult.setData(data);
        axiosResult.setStatus(axiosStatus.getStatus());
        axiosResult.setMessage(axiosStatus.getMessage());
        return axiosResult;
    }

    /**
     * 成功 不返回数据
     * @param <T>
     * @return
     */
    public static <T> AxiosResult<T> success(){
        return setData(AxiosStatus.OK,null);
    }

    /**
     * 成功返回数据
     * @param <T>
     * @return
     */
    public static <T>AxiosResult<T> success(T data){
       return setData(AxiosStatus.OK,data);
    }

    /**
     * 成功 返回自定义状态吗 不携带数据
     * @param <T>
     * @return
     */
    public static <T>AxiosResult<T> success(AxiosStatus axiosStatus){
        return setData(axiosStatus,null);
    }

    /**
     * 成功 返回自定义状态吗 携带数据
     * @param <T>
     * @return
     */
    public static <T>AxiosResult<T> success(AxiosStatus axiosStatus,T data){
        return setData(axiosStatus,data);
    }

    /**
     * 失败 不返回数据
     * @param <T>
     * @return
     */
    public static <T> AxiosResult<T> error(){
        return setData(AxiosStatus.ERROR,null);
    }
    /**
     * 失败 返回数据
     * @param <T>
     * @return
     */
    public static <T> AxiosResult<T> error(T data){
        return setData(AxiosStatus.ERROR,data);
    }

    /**
     * 失败 返回自定义状态吗 不携带数据
     * @param <T>
     * @return
     */

    public static <T> AxiosResult<T> error(AxiosStatus axiosStatus){
        return setData(axiosStatus,null);
    }

    /**
     * 失败 返回自定义状态吗 携带数据
     * @param <T>
     * @return
     */

    public static <T> AxiosResult<T> error(AxiosStatus axiosStatus,T data){
        return setData(axiosStatus,data);
    }


}
