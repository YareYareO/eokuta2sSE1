package org.hbrs.se1.ws21.uebung3.persistence;

import java.util.ArrayList;
import java.util.List;

public class MemberView {
    public static void dump(List<Member> liste){
        for (Member x:liste) {
            System.out.println(x);
        }
    }
}
