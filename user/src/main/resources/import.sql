INSERT INTO users (email, password, name, grade, order_count, created_at) VALUES ('test1@test.com', '1234', '홍길동', 'GRADE1', 0, now());

INSERT INTO delivery_address (address, zip_code, is_default, user_id, created_at) VALUES ('서울특별시 강남구 강남대로 123 성공 빌딩 15층', '00001', true, 1, now());
INSERT INTO delivery_address (address, zip_code, is_default, user_id, created_at) VALUES ('서울특별시 강남구 강남대로 123 성공 빌딩 14층', '00001', false, 1, now());
