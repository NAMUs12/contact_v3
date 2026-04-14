package repository;

import ContactMain;
import vo.Contact;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ContactRepository {

    public void save(Contact contact) {
        // contactMap에 id를 key로, Contact를 value로 추가
        ContactMain.contactMap.put(contact.getAge(), contact);
        System.out.println("저장했습니다.");
    }

    // 반환 타입 : Map<Integer, Contact>
    public Map<Integer, Contact> findAll() {
        return ContactMain.contactMap;
    }

    public Optional<Contact> findById(int id) {
        Contact contact = ContactMain.contactMap.get(id);
        if (contact != null) {
            return Optional.of(contact);
        }
        return Optional.empty();
    }

    public void delete(int deleteId) {
        ContactMain.contactMap.remove(deleteId);
    }

    public void update(int updateId, Contact afterContact) {
        ContactMain.contactMap.put(updateId, afterContact);
    }

    // 반환 타입 : Map<Integer, Contact>
    public Map<Integer, Contact> search(String searchName) {
        Map<Integer, Contact> searchResult = new HashMap<>();
        // entrySet() : Key + Value 쌍(entry)을 전부 꺼내서 순회
        for (Map.Entry<Integer, Contact> entry : ContactMain.contactMap.entrySet()) {
            if (entry.getValue().getName().contains(searchName)) {
                searchResult.put(entry.getKey(), entry.getValue());
            }
        }
        return searchResult;
    }
}