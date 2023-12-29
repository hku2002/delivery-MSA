/* 가게1 */
INSERT INTO store (name, thumbnail_path, created_at) VALUES ('Store 1', 'http://localhost:8080/image/store/store1_thumbnail.jpg', now());
INSERT INTO menu (name, description, thumbnail_path, price, store_id, created_at) VALUES ('Store1 - Menu 1', 'Description for Menu 1', 'http://localhost:8080/image/store/store1_menu1_thumbnail.jpg', 8000, 1, now());
INSERT INTO options (name, price, menu_id, created_at) VALUES ('옵션 추가1', 1000, 1, now());
INSERT INTO options (name, price, menu_id, created_at) VALUES ('옵션 추가2', 500, 1, now());
INSERT INTO menu (name, description, thumbnail_path, price, store_id, created_at) VALUES ('Store1 - Menu 2', 'Description for Menu 2', 'http://localhost:8080/image/store/store1_menu2_thumbnail.jpg', 9000, 1, now());
INSERT INTO options (name, price, menu_id, created_at) VALUES ('감자 추가', 1200, 2, now());
INSERT INTO options (name, price, menu_id, created_at) VALUES ('마늘 추가', 2000, 2, now());

/* 가게2 */
INSERT INTO store (name, thumbnail_path, created_at) VALUES ('Store 2', 'http://localhost:8080/image/store/store2_thumbnail.jpg', now());
INSERT INTO menu (name, description, thumbnail_path, price, store_id, created_at) VALUES ('Store2 - Menu 1', 'Description for Menu 1', 'http://localhost:8080/image/store/store2_menu1_thumbnail.jpg', 15000, 1, now());
INSERT INTO options (name, price, menu_id, created_at) VALUES ('스프 추가', 2000, 3, now());
INSERT INTO options (name, price, menu_id, created_at) VALUES ('국 추가', 2000, 3, now());
INSERT INTO menu (name, description, thumbnail_path, price, store_id, created_at) VALUES ('Store2 - Menu 2', 'Description for Menu 2', 'http://localhost:8080/image/store/store2_menu2_thumbnail.jpg', 16000, 1, now());
INSERT INTO options (name, price, menu_id, created_at) VALUES ('옵션 추가 없음', 0, 4, now());
INSERT INTO options (name, price, menu_id, created_at) VALUES ('후추 추가', 500, 4, now());
