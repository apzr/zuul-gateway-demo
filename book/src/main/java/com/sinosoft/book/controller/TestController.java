package com.sinosoft.book.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
public class TestController {


    @RequestMapping(value = "/test")
    public ResponseEntity<?> checkedOut() {
        String result = sendGet("http://192.168.0.134:8888/api/user/list", null);
        return ResponseEntity.ok(   JSONArray.parse(result) );
    }

    /**
     * 向指定URL发送GET方法的请求
     * @param url：发送请求的URL
     * @param param：请求参数，请求参数应该是 name1=value1&name2=value2&name3=value3 的形式。
     * @return String[result]：所代表远程资源的响应结果
     */
    private String sendGet(String url, String param) {
        String result = "";
        BufferedReader in = null;
        try {
            String urlNameString = url + "?" + param;
            URL realUrl = new URL(urlNameString);

            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();

            // 设置通用的请求属性
            connection.setRequestProperty("Authorization", "bearer eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJSU0hhR0NURkVSSmdhN3V4TjVLckR2dzQ5VDVLZkRRcDN1enMxaXJsbnlBIn0.eyJleHAiOjE2MzQxMjcwMTYsImlhdCI6MTYzNDA5MTAxNiwianRpIjoiODM0YjkxYzItODQ0Mi00NzZiLTkxYmMtZDkzNjg4MGMwNjMzIiwiaXNzIjoiaHR0cDovLzEyNy4wLjAuMTo4MDgwL2F1dGgvcmVhbG1zL215cmVhbG0iLCJhdWQiOiJhY2NvdW50Iiwic3ViIjoiMWNhMTVmMjktMmQ4ZS00Nzc3LTg4MzItMTZjN2VmOGM2MzczIiwidHlwIjoiQmVhcmVyIiwiYXpwIjoibG9jYWxob3N0ODg4OCIsInNlc3Npb25fc3RhdGUiOiJhZmViMTY4Yi1kNGJhLTQ3MDYtYjc5OS0wMWY4NTE2Nzg2MjkiLCJhY3IiOiIxIiwiYWxsb3dlZC1vcmlnaW5zIjpbImh0dHA6Ly9sb2NhbGhvc3Q6ODg4OCIsImh0dHA6Ly8xOTIuMTY4LjAuMTM1Ojg4ODgiXSwicmVhbG1fYWNjZXNzIjp7InJvbGVzIjpbImRlZmF1bHQtcm9sZXMtbXlyZWFsbSIsIlRFU1RST0xFX2VkaXRlZCIsIm9mZmxpbmVfYWNjZXNzIiwiUk9MRV9WSUVXRVIiLCJST0xFX1RFU1QiLCJ1bWFfYXV0aG9yaXphdGlvbiJdfSwicmVzb3VyY2VfYWNjZXNzIjp7ImFjY291bnQiOnsicm9sZXMiOlsibWFuYWdlLWFjY291bnQiLCJtYW5hZ2UtYWNjb3VudC1saW5rcyIsInZpZXctcHJvZmlsZSJdfX0sInNjb3BlIjoiZW1haWwgcHJvZmlsZSIsInNpZCI6ImFmZWIxNjhiLWQ0YmEtNDcwNi1iNzk5LTAxZjg1MTY3ODYyOSIsImVtYWlsX3ZlcmlmaWVkIjpmYWxzZSwibmFtZSI6ImZpcnN0TmFtZSBsYXN0TmFtZSIsInByZWZlcnJlZF91c2VybmFtZSI6InVzZXJuYW1lIiwibG9jYWxlIjoiemgtQ04iLCJnaXZlbl9uYW1lIjoiZmlyc3ROYW1lIiwiZmFtaWx5X25hbWUiOiJsYXN0TmFtZSIsImVtYWlsIjoiaXN3YWxsb3cxbDJsQDEyNi5jb20ifQ.ZNmYkiM03hnaOesue9yGiU8bTMMsvnIF94qmu1d4nAnuy3XN3f_xfRNw8gw0pFA7X70SiXsqPCeIkxDGjGwaSbloMT_6FA1MA5awaMaJ9tGbmDCCYnkFyMP4uX5w3iBgXs_Gcu1_rHjI2i7wVjj98CifYmNlISbh2UJV6t5ojDTetwKuaPu6_KBzQ5KNI9ZzNN6iNycK_bzNofNwnNr4MlfZIRMVHPo1EsKYf_G6z8JKH7NWP4iVN7oEv0SxMYmYWv2QfrVva-4bNqMf2jscRYTZ74IJZEZztf_6YxZASRH7s29JvTFzWWaOiO3uoopSqcPKl4GAlbcj-dMMHbD-XQ");
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");

            // 建立实际的连接
            connection.connect();

            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();

            // 遍历所有的响应头字段
            for (String key : map.keySet()) {
                System.out.println(key + "--->" + map.get(key));
            }


            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        }

        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result;
    }
}