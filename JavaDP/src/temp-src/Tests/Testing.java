package Tests;


import java.util.HashMap;
import java.util.Map;

public class Testing {
    public static void main(String[] args) {
        Map<String, Object> emailResult = new HashMap<String, Object>();
        emailResult.put("stam", "1");

        StringBuilder emailResultInfo  = new StringBuilder();
        emailResultInfo.append("User Message: ").append(emailResult.get("userMessage") != null ? emailResult.get("userMessage").toString() : "empty")
                .append(", resultCode: " ).append(emailResult.get("resultCode") != null ? emailResult.get("resultCode").toString() : "empty")
                .append(", insightId: " ).append(emailResult.get("insightId") != null ? emailResult.get("insightId").toString() : "empty")
                .append(", supportResultCode: ").append(emailResult.get("supportResultCode") != null ? emailResult.get("supportResultCode").toString() : "empty")
                .append(", supportMessage: ").append(emailResult.get("supportMessage") != null ? emailResult.get("supportMessage").toString() : "empty");

        System.out.println(emailResultInfo.toString());
    }
}