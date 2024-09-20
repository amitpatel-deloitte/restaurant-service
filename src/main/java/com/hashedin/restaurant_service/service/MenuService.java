package com.hashedin.restaurant_service.service;

import com.hashedin.restaurant_service.exceptionHandler.NotFoundException;
import com.hashedin.restaurant_service.model.Item;
import com.hashedin.restaurant_service.model.Menu;
import com.hashedin.restaurant_service.model.MenuDTO;
import com.hashedin.restaurant_service.model.Restaurant;
import com.hashedin.restaurant_service.repository.ItemRepository;
import com.hashedin.restaurant_service.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class MenuService {

    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private ItemRepository itemRepository;

    public List<Menu> getAllMenus() {
        return menuRepository.findAll();
    }

    public Optional<Menu> getMenuById(int id) {
        Menu menu = menuRepository.findById(id)
                .orElseThrow(() -> new NotFoundException( " Menu with " + id + " not found"));
        return menuRepository.findById(id);
    }

    public Menu saveMenu(Menu menu){
        return menuRepository.save(menu);
    }

    public Menu createMenuWithItems(String menuName, List<Integer> itemsIds) {
        Menu menu = new Menu();
        menu.setName(menuName);
        List<Item> items = itemRepository.findAllById(itemsIds);
        menu.setItems(items);
        return menuRepository.save(menu);
    }

    public Menu updateMenu(int id, MenuDTO menuDTO) {
        Menu existingMenu = menuRepository.findById(id)
                .orElseThrow(() -> new NotFoundException( " Menu with " + id + " not found"));

        if(menuDTO.getName() != null){
            existingMenu.setName(menuDTO.getName());
        }

        if (menuDTO.getItemIds() != null && !menuDTO.getItemIds().isEmpty()){
            List<Item> items =  itemRepository.findAllById((menuDTO.getItemIds()));
            existingMenu.setItems(items);
        }
        return menuRepository.save(existingMenu);
    }

    public void deleteMenu(int id) {
        Menu menu = menuRepository.findById(id)
                .orElseThrow(() -> new NotFoundException( " Menu with " + id + " not found"));
        menuRepository.delete(menu);
    }
}
