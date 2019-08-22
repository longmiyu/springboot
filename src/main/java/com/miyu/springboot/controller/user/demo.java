package com.miyu.springboot.controller.user;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;

import java.util.Map;
import java.util.WeakHashMap;

public class demo {

    public final static Map<String, Client> WS_CLIENT_MAP = new WeakHashMap<String, Client>(
            64);

    public static void main(String[] args) {
        String url = "http://127.0.0.1:8080/framework/componentservices/CommonWebService?wsdl";

        /*
         * try { Client client = new Client(new URL(url)); Object[] params = new
         * Object[3]; params[0] = "budgbase_BudgOpenOaInteractionBO_bo";
         * params[1] = "checkBudgSendResult"; params[2] = "44"; Object[] result
         * = client.invoke("run", params);
         * System.out.println(result.toString()); } catch (Exception e) { //
         * TODO Auto-generated catch block e.printStackTrace(); }
         */
        try {
            Client client = WS_CLIENT_MAP.get(url);
            JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory
                    .newInstance();
            client = dcf.createClient(url);
            // client.setThreadLocalRequestContext(true);
            HTTPConduit http = (HTTPConduit) client.getConduit();
            HTTPClientPolicy httpClientPolicy = new HTTPClientPolicy();
            httpClientPolicy.setConnectionTimeout(90000);
            httpClientPolicy.setAllowChunking(false);
            httpClientPolicy.setReceiveTimeout(90000);
            http.setClient(httpClientPolicy);
            // WS_CLIENT_MAP.put(url, client);
            Object[] params = new Object[3];
            params[0] = "acctPay_slryOpenOaInteraction_slryOpenOaInteractionBO_bo";
            params[1] = "changeSlryEmp";
            params[2] = "[{\"deptCodeNew\":\"300101\",\"empName\":\"陈星羽\",\"account\":\"sys\",\"billCode\":\"20190008\",\"createDate\":\"2019-06-17\",\"compCode\":\"100104\",\"empCode\":\"G8017\"}]";
            Object[] res = client.invoke("run", params);
            System.out.println(res);
        } catch (Exception e) {

            e.printStackTrace();
        }


    }

    }
