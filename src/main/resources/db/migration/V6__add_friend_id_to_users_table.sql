ALTER TABLE friends ADD userid BIGINT;
ALTER TABLE friends ADD FOREIGN KEY (userid) REFERENCES users(id);