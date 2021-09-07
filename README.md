# Facebook-Clone

# Requirements

## Functional 
- Users can create account
- Users can log in 
- Users can logout
- Users can share, like, comment, delete, create, update post
- Users can change post access to public or private
- Users can see news feeds
- Users can add friend
- Users can send friend request
- Users can accept friend request
- Users can reject friend request
- Users can send, update, delete message 
- Users can reply a specific message
- Users delete account
- Users can create chat room 
- Users can send message, delete and update message in chatroom
- Users can add book to store
- Users can see news feeds
- Users can delete, update book in store
- Users can create todo list
- Users can add, update delete todo
- Users can check and uncheck todo
- Users can add description to todo

## Non Functional 
- Application should be secure
- Application should be Test driven
- Application should be available

## Database Design
- POST
    - id: bigint, autoIncrement, primary key
    - text: text
    - user: USER
    - created_on: localDateTime
    - updated_on: localDateTime
  

- POST_MEDIA
    - id: bigint
    - file: varchar(url)
    - post: POST
    - created_on: datetime
    - updated_on: datetime
  

- BOOK
  - id: bigint, autoIncrement, primary key
    - title: text 
    - author: USER
    - published_on: localDateTime
    - book_file: file
    - created_on: localDateTime
    - updated_on: localDateTime
  

- USER
  - id: bigint, autoincrement, primary
    - username: varchar(20)
    - email: varchar(128)
    - roles: ROLE(USER)
    - created_on: datetime
    - updated_on: datetime
    

- ADMIN
    - id: bigint, autoincrement, primary
        - username: varchar(20)
        - email: varchar(128)
        - - roles: ROLE(ADMIN)
        - created_on: datetime
        - updated_on: datetime
        
- PROFILE
  - id: bigint, autoincrement, primary
    - owner: USER
    - image: varchar(url)
    - address: ADDRESS
    - created_on: datetime
    - updated_on: datetime
    

- COMMENT
  - id: bigint, autoincrement, primary
    - text: text
    - author: USER
    - created_on: datetime
    - updated_on: datetime
    
  
- LIKE
    - id: bigint, autoincrement, primary
    - post: POST
    - owner: USER
    - created_on: datetime
    - updated_on: datetime
    

- TODO
  - id: bigint, autoIncrement, primary key
  - title: text
  - description: text
  - label: LABEL
  - priority: PRIORITY
  - user: USER
  - created_on: localDateTime
  - updated_on: localDateTime


- MESSAGE
  - id: bigint, autoIncrement, primary key
  - message: text
  - sender_id: text
  - receiver_id: text
  - created_on: localDateTime
  - updated_on: localDateTime
  - linked_messages: text

- CHAT_ROOM
  - id: bigint, autoIncrement, primary key
  - admins: USER
  - members: USER
  - group_name: text
  - messages: MESSAGE


- ROLE
    - id: bigint, autoincrement, primary
    - role_name: ROLE_NAME
    - permissions: PERMISSION

- ROLE_NAME
    constants: ADMIN, USER, ELDERS, NATIVE

- PERMISSION
    constants: READ, WRITE, CREATE, DELETE