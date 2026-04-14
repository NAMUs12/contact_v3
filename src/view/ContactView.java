package view;

import service.ContactService;
import vo.Contact;

import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

public class ContactView {
    private ContactService contactService = new ContactService();
    private Scanner sc = new Scanner(System.in);

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
        String searchName = sc.next();

        Map<Integer, Contact> searchMap = contactService.search(searchName);

        if (searchMap.isEmpty()) {                          // Map은 isEmpty() 사용
            System.out.println("검색 결과 없음.");
        } else {
            // values() : Map에서 Contact(값)만 꺼내서 순회
            for (Contact contact : searchMap.values()) {
                System.out.println(contact);
            }
        }
    }

    // 전체 목록 : Map으로 받아서 values()로 출력
    private void readAll() {
        Map<Integer, Contact> map = contactService.findAll();

        if (map.isEmpty()) {                                // Map은 isEmpty() 사용
            System.out.println("목록이 비었어요");
            return;
        }
        // values() : Map에서 Contact(값)만 꺼내서 순회
        for (Contact contact : map.values()) {
            System.out.println(contact);
        }
    }

    // 추가 : 변경 없음
    private void create() {
        System.out.println("이름을 입력하세요.");
        String name = sc.next();
        System.out.println("전화번호를 입력하세요.");
        String phone = sc.next();
        contactService.create(name, phone);
    }

    // 수정 : Map으로 받아서 비어있는지 확인 후 출력
    private void update() {
        Map<Integer, Contact> map = contactService.findAll();

        if (map.isEmpty()) {
            System.out.println("리스트가 비어 있어요");
            System.out.println("메뉴로 이동합니다.");
            return;
        }

        for (Contact contact : map.values()) {
            System.out.println(contact);
        }

        System.out.println("수정할 id를 입력하세요.");
        int updateNumber = sc.nextInt();

        Optional<Contact> beforeContact = contactService.findById(updateNumber);
        if (!beforeContact.isPresent()) {
            System.out.println("해당하는 ID 정보가 없습니다.");
            return;
        }

        Contact afterContact = beforeContact.get();

        System.out.println("- 변경 전 : " + afterContact.getName());
        System.out.println("수정할 이름을 입력하세요. (엔터치면 안바뀜)");
        String afterName = sc.next();
        if (!afterName.equals("")) {
            afterContact.setName(afterName);
        }

        System.out.println("- 변경 전 : " + afterContact.getPhone());
        System.out.println("수정할 전화번호를 입력하세요. (엔터치면 안바뀜)");
        String afterPhone = sc.next();
        if (!afterPhone.equals("")) {
            afterContact.setPhone(afterPhone);
        }

        contactService.update(updateNumber, afterContact);
    }

    // 삭제 : Map으로 받아서 비어있는지 확인 후 출력
    private void delete() {
        Map<Integer, Contact> map = contactService.findAll();

        if (map.isEmpty()) {
            System.out.println("리스트가 비어 있어요");
            System.out.println("메뉴로 이동합니다.");
            return;
        }

        for (Contact contact : map.values()) {
            System.out.println(contact);
        }

        System.out.println("삭제할 id를 입력하세요.");
        int deleteNumber = sc.nextInt();
        contactService.delete(deleteNumber);
    }
}