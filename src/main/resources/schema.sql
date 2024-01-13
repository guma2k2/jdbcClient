DROP TABLE IF EXISTS post;

CREATE TABLE post (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    slug VARCHAR(255) NOT NULL,
    date DATE NOT NULL,
    time_to_read INT NOT NULL,
    tags VARCHAR(255) NOT NULL
);

INSERT INTO post (title, slug, date, time_to_read, tags)
VALUES ('Hello, World!', 'hello-world', CURRENT_DATE, 5, 'Spring Boot, Java');

INSERT INTO post (title, slug, date, time_to_read, tags)
VALUES ('Introduction to SQL', 'sql-intro', CURRENT_DATE, 8, 'Database, SQL');

INSERT INTO post (title, slug, date, time_to_read, tags)
VALUES ('Python Basics', 'python-basics', CURRENT_DATE, 6, 'Python, Programming');

INSERT INTO post (title, slug, date, time_to_read, tags)
VALUES ('Web Development with HTML and CSS', 'web-dev-html-css', CURRENT_DATE, 10, 'Web Development, HTML, CSS');

INSERT INTO post (title, slug, date, time_to_read, tags)
VALUES ('JavaScript Fundamentals', 'js-fundamentals', CURRENT_DATE, 7, 'JavaScript, Programming');

INSERT INTO post (title, slug, date, time_to_read, tags)
VALUES ('Data Structures in Python', 'python-data-structures', CURRENT_DATE, 9, 'Python, Data Structures');

INSERT INTO post (title, slug, date, time_to_read, tags)
VALUES ('Introduction to Machine Learning', 'ml-intro', CURRENT_DATE, 12, 'Machine Learning, AI');

INSERT INTO post (title, slug, date, time_to_read, tags)
VALUES ('Getting Started with Docker', 'docker-intro', CURRENT_DATE, 6, 'Docker, Containers');

INSERT INTO post (title, slug, date, time_to_read, tags)
VALUES ('Responsive Web Design Techniques', 'responsive-web-design', CURRENT_DATE, 8, 'Web Development, CSS');

INSERT INTO post (title, slug, date, time_to_read, tags)
VALUES ('Java 101: Getting Started', 'java-getting-started', CURRENT_DATE, 7, 'Java, Programming');
