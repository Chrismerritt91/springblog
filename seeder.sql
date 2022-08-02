USE springblog_db;



INSERT INTO users(username, email, password)
VALUES ('Chris Merritt', 'Chris@test.com', 'chris1');

INSERT INTO post_images(image, post_id)
VALUES ('https://3titxt47avtl441y1n3hv68y-wpengine.netdna-ssl.com/wp-content/uploads/sites/3/2021/03/20-ugly-cat-GettyImages-98830554-scaled-e1608240675708-770.jpg', 3),
       ('https://images2.minutemediacdn.com/image/upload/c_fill,g_auto,h_1248,w_2220/v1555285106/shape/mentalfloss/chinchilla_cat_5833713404_1.jpg?itok=vkNCc-u9', 3),
       ('https://www.thesprucepets.com/thmb/ih8Z-ifZlL9h9f6_1kmgZi3nNmQ=/3000x2178/filters:fill(auto,1)/cats-118824989-584d83d33df78c491e316973.jpg', 3);