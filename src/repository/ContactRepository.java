package repository;

import main.Main;
import vo.Contact;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ContactRepository {

    public void save(Contact contact) {
        // contactMap에 id를 key로, Contact를 value로 추가
        Main.contactMap.put(contact.getId(), contact);
        System.out.println("저장했습니다.");
    }

    // 반환 타입 : Map<Integer, Contact>
    public Map<Integer, Contact> findAll() {
        return Main.contactMap;
    }

    public Optional<Contact> findById(int id) {
        Contact contact = Main.contactMap.get(id);
        if (contact != null) {
            return Optional.of(contact);
        }
        return Optional.empty();
    }

    public void delete(int deleteId) {
        Main.contactMap.remove(deleteId);
    }

    public void update(int updateId, Contact afterContact) {
        Main.contactMap.put(updateId, afterContact);
    }

    // 반환 타입 : Map<Integer, Contact>
    public Map<Integer, Contact> search(String searchName) {
        Map<Integer, Contact> searchResult = new HashMap<>();
        // entrySet() : Key + Value 쌍(entry)을 전부 꺼내서 순회
        for (Map.Entry<Integer, Contact> entry : Main.contactMap.entrySet()) {
            if (entry.getValue().getName().contains(searchName)) {
                searchResult.put(entry.getKey(), entry.getValue());
            }
        }
        return searchResult;
    }
}