package com.bonc.bcos.common;

import com.bonc.bcos.consts.ReturnCode;
import com.bonc.bcos.service.exception.ClusterException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface ApiHandle {
    Logger LOG = LoggerFactory.getLogger(ApiHandle.class);

    Object handle() throws Exception;

    static ApiResult handle(ApiHandle proxy){
        return handle(proxy,"",LOG);
    }

    static ApiResult handle(ApiHandle proxy,Logger log){
        return handle(proxy,"",LOG);
    }

    static ApiResult handle(ApiHandle proxy,Object param){
        return handle(proxy,param,LOG);
    }

    static ApiResult handle(ApiHandle proxy,Object param,Logger log){
        try {
            Object data = proxy.handle();
            return new ApiResult(ReturnCode.CODE_SUCCESS,data,"操作成功！");
        }catch (ClusterException e){
            log.error("业务异常：请求参数:{} 编码：{},  信息：{}，详情：{}",param,e.getCode(),e.getMsg(),e.getDetail());
            return new ApiResult(e.getCode(),e.getDetail(),e.getMsg());
        }catch (Exception e){
            e.printStackTrace();
            log.error("系统异常: {}",e.getMessage());
            return new ApiResult(ReturnCode.CODE_CLUSTER_SYSTEM_ERROR,e.getMessage(),"系统异常");
        }
    }

}
