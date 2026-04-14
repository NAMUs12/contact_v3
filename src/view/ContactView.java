package view;

import service.ContactService;
import vo.Contact;

import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

public class ContactView {
    private final Scanner sc;
    private final ContactService contactService;

    public ContactView(Scanner sc, ContactService contactService) {
        this.sc = sc;
        this.contactService = contactService;
    }

    public void run() {
        while (true) {
            System.out.println("1.추가  2.목록  3.수정  4.삭제  5.이름의 일부로 검색 -1:종료");
            int cmd = sc.nextInt();
            switch (cmd) {
                case -1:
                    return;
                case 1:
                    create();
                    break;
                case 2:
                    readAll();
                    break;
                case 3:
                    update();
                    break;
                case 4:
                    delete();
                    break;
                case 5:
                    search();
                    break;
                default:
                    System.out.println("잘 못 입력 함.");
            }
        }
    }

    // 검색 : Map으로 결과를 받아서 values()로 출력
    private void search() {
        System.out.println("검색할 이름의 일부를 입력하세요");
    }

    // 전체 목록 : Map으로 받아서 values()로 출력
    private void readAll() {
    }

    // 추가 : 변경 없음
    private void create() {
        // 이름과 나이, 전화번호를 입력받아서 서비스에게 전달한다.
        String name;
        int age;
        String phone;
        System.out.println("이름 : ");
        name = sc.next();
        System.out.println("나이 : ");
        age = sc.nextInt();
        System.out.println("전화번호 : ");
        phone = sc.next();
        // 받은 값들을 Service.ContactService.insert() 전달
        contactService.insert(name, age, phone);
    }

    // 수정 : Map으로 받아서 비어있는지 확인 후 출력
    private void update() {
    }

    // 삭제 : Map으로 받아서 비어있는지 확인 후 출력
    private void delete() {
    }
}