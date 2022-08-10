Create database if not exists myBlog;

use myBlog;

CREATE TABLE `posts` (
  `id` INT NOT NULL,
  `title` VARCHAR(255) NOT NULL,
  `description` VARCHAR(255) NOT NULL,
  `content` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE)
  engine=InnoDB default charset=utf8mb4 collate=utf8mb4_0900_ai_ci;