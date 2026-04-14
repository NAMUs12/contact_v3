package main;

import view.ContactView;
import vo.Contact;

import java.util.HashMap;
import java.util.Map;

public class Main {
    // 주소록 저장할 Map 변수 (key: id, value: Contact)
    public static Map<Integer, Contact> contactMap = new HashMap<>();
    // id를 자동 증가할 변수
    public static int nextId = 1;

    public static void main(String[] args) {
        ContactView contactView = new ContactView();
        contactView.run();
    }
}