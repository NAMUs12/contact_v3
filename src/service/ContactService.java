package service;

import main.Main;
import repository.ContactRepository;
import vo.Contact;

import java.util.Map;
import java.util.Optional;

public class ContactService {
    private ContactRepository contactRepository = new ContactRepository();

    public void create(String name, String phone) {
        Contact contact = new Contact(Main.nextId, name, phone);
        Main.nextId++;
        contactRepository.save(contact);
    }

    // 반환 타입 : Map<Integer, Contact>
    public Map<Integer, Contact> findAll() {
        return contactRepository.findAll();
    }

    public void delete(int deleteId) {
        Optional<Contact> findContact = contactRepository.findById(deleteId);
        if (findContact.isPresent()) {
            contactRepository.delete(deleteId);
            System.out.println("정상적으로 삭제되었습니다.");
        } else {
            System.out.println("존재하지 않은 ID입니다. 다시 확인해주세요.");
        }
    }

    public Optional<Contact> findById(int id) {
        return contactRepository.findById(id);
    }

    public void update(int updateId, Contact afterContact) {
        contactRepository.update(updateId, afterContact);
    }

    // 반환 타입 : Map<Integer, Contact>
    public Map<Integer, Contact> search(String searchName) {
        return contactRepository.search(searchName);
    }
}