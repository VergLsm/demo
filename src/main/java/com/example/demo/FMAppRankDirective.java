package com.example.demo;

import java.io.IOException;
import java.util.Map;

import javax.annotation.Resource;

import freemarker.core.Environment;
import freemarker.template.ObjectWrapper;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

/**
 * FreeMarker自定义宏
 * 获取App下载排行列表
 * 参数包括 length（列表长度） mtypeCode(主类型代码)
 * typeCode（小类型代码） rankMode（排行模式1、2、3）
 * @author shannon  
 */
public class FMAppRankDirective implements TemplateDirectiveModel {
 
    @Override
    public void execute(Environment env, Map params, TemplateModel[] loopVars,
            TemplateDirectiveBody body) throws TemplateException, IOException {

        env.setVariable("appRankList", ObjectWrapper.DEFAULT_WRAPPER.wrap("55555"));
        if (body != null) {
            body.render(env.getOut());
        }
    }

}