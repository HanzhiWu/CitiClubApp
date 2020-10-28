package com.example.citiclubapp.Entity;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 用来记录仓单入库的状态
 */
public class Condition {
    private static Map<Integer,String> conditonMap;
    public static final int REQUEST=0;
    public static final int WAIT_FOR_CHECK=1;
    public static final int SIGN_ASSIGNMENT=2;
    public static final int SEND_CARGO=3;
    public static final int CERTIFICATE_CARGO=4;
    public static final int MAKE_WARRANT=5;
    public static final int GURANTEE=6;
    public static final int FINISH=7;
    public static final int ISZHIYA=8;
    static {
        conditonMap=new HashMap<>();
        conditonMap.put(0,"申请");
        conditonMap.put(1,"等待审核");
        conditonMap.put(2,"签署合同");
        conditonMap.put(3,"发货");
        conditonMap.put(4,"仓储公司确认收货");
        conditonMap.put(5,"制单");
        conditonMap.put(6,"担保机构背书");
        conditonMap.put(7,"已生成");
        conditonMap.put(8,"是否质押");
    }


    public static String getCondition(int number){
        return conditonMap.get(number);
    }
    public int getKeyByValue(String value){
        Set<Integer> keys=conditonMap.keySet();
        Iterator<Map.Entry<Integer, String>> it = conditonMap.entrySet().iterator();
        int result=-1;
        while(it.hasNext()){
            Map.Entry<Integer, String> entry=it.next();
            String res=entry.getValue();
            if(res.equals(value)) {
                result = entry.getKey();
                break;
            }
        }
        return result;
    }
    public String getValue(int id) {
        return conditonMap.get(id);
    }

    public static String returnConditionText(int conditonCode) {
        String res="";
        if(conditonCode==SIGN_ASSIGNMENT){
            res="您的仓单已通过审核，请提交合同文件";
        }else if(conditonCode==GURANTEE){
            res="仓储公司已确认收货，请选择是否选择担保机构";
        }else if(conditonCode==FINISH){
            res="您的仓单已经生成，请查看业务状态";
        }else if(conditonCode==ISZHIYA){
            res="您的仓单已完成质押，请查看详情";
        }
        return res;
    }
}
