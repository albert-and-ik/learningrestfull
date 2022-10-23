# Задание

Backend-приложение, которое будет иметь несколько контрольных точек.
<details>
<summary>
 Api Drivers
</summary>

### GET /drivers/list 
Ответ: DriverShort[]

### GET /drivers/{id} 
Ответ: Driver

### POST /drivers
Тело: NewDriver <br>
Код ответа: 201 Created <br>
Ответ: UUID 
</details>

<details>
<summary>Api Cars</summary>

### GET /cars/list 
Ответ: CarShort[]

### GET /cars/{id} 
Ответ: Car

### POST /cars 
Тело: NewCar<br>
Код ответа: 201 Created<br>
Ответ: UUID

### PATCH /cars/{id}?status=SOLD или DISCARDED <br> 

{id} - переменная пути, UUID
</details>


<details>
<summary>
Описание моделей
</summary>
Все поля обязательные 


### DriverShort: 
UUID водителя, <br>
имя,<br>
категорию водительский прав (enum)

### Driver: 
Содержит всё, что содержится в DriverShort + :<br>
возраст,<br>
список всех автомобилей, которыми владеет,<br>
дата и время создания

### NewDriver: 
имя,<br>
категория прав,<br>
возраст<br>


### CarShort: 
UUID автомобиля, <br>
модель,<br>
VIN автомобиля

### Car: 
Содержит всё, что содержится в CarShort + : <br>
гос. номер,<br>
пробег,<br>
статус - CREATED, SOLD или DISCARDED <br>
владелец - DriverShort, <br>
дата и время создания <br>

### NewCar:  
модель,<br>
VIN автомобиля,<br>
гос. номер,<br>
пробег,<br>
владелец - UUID

</details>

<details>
<summary>
    Дополнительно
</summary>
1. 	Транзакции <br>
2. 	Маппинг<br>
3. 	DI<br>
4. 	Наследование<br>
5. 	Инкапсуляция<br>
6. 	Аннотации<br>
7. 	Swagger<br>
8. 	Optional code example<br>
9. 	impl pageable<br>
10. Мягкое удаление <br>
11. CreateAt, DeleteAt<br>
</details>