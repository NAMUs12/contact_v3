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
        System.out.println("[ContactView.search()]");
        System.out.println("검색어(이름) : ");
        String keyword = sc.next();
        Map<Long, Contact> result = contactService.search(keyword);
        // 검색결과 출력
        if (result.isEmpty()) {
            System.out.println("검색 결과가 없습니다.");
        } else {
            for (Long key : result.keySet()) {
                System.out.println(result.get(key));
            }
        }
    }

    // 전체 목록 : Map으로 받아서 values()로 출력
    private void readAll() {
        // 맵을 읽어와서 화면 출력
        Map<Long, Contact> store = contactService.findAll();
        // 출력
        // store 비어 있으면 없다고 출력한 후 종료
        if (store.isEmpty()) {
            System.out.println("저장된 자료가 없습니다");
        }
        for (Long key : store.keySet()) {
            System.out.println(store.get(key));
        }
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
        System.out.println("[ContactView.update()]");
        System.out.println("수정할 아이디 : ");
        Long updateId = sc.nextLong();
        System.out.println("수정할 전화번호 : ");
        String updatePhone = sc.next();
        contactService.update(updateId, updatePhone);
    }

    // 삭제 : Map으로 받아서 비어있는지 확인 후 출력
    private void delete() {
        System.out.println("삭제할 아이디 : ");
        Long deleteId = sc.nextLong();
        // 서비스로 id 보내기
        contactService.delete(deleteId);
    }
}