package com.eazybytes.eazyschool.audit;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class EazyschoolnfoContributor implements InfoContributor {
    @Override
    public void contribute(Info.Builder builder) {
        HashMap<String, String> eazyMap = new HashMap<>();
        eazyMap.put("App Name", "EazySchool");
        eazyMap.put("App Description", "Eeazy School Aapplication for Students and Admin");
        eazyMap.put("App Version", "1.0.0");
        eazyMap.put("Contact Email", "info@eazyschool.com");
        eazyMap.put("Contocat Mobile", "+1(21) 12343 3434");
        builder.withDetail("eazyschool-info", eazyMap);
    }
}
