https://ethereal-argument-f0f.notion.site/2-API-1c05ae04b72648aea00d7c815fbd810e

| Method  | URI | Description | Request | Response |
| --- | --- | --- | --- | --- |
| POST | /pet | 새로운 애완동물 정보 Create | [Request Body]
{ String name, 
  String species,
  String gender,
  int age } | Long petId + "번 애완동물이 등록되었습니다!” |
| GET | /pet/:petId | 특정 애완동물 정보 Read | [Path Variables]
Long petId | { Long id,
   String name,
   String species,
   String gender,
   int age } |
| GET | /pet | 모든 애완동물 정보 Read | X | List [
{ Long id,
   String name,
   String species,
   String gender,
   int age }, … ] |
| PUT | /pet | 특정 애완동물 정보 Update | [Request Body]
{ Long id,
   String name,
   String species,
   String gender,
   int age } | Long petId + "번 애완동물이 수정되었습니다!” |
| DELETE | /pet/:petId | 특정 애완동물 정보 Delete | [Path Variables]
Long petId | Long petId + "번 애완동물 삭제 여부: " 
+ Boolean isDeleted |
|  |  |  |  |  |
