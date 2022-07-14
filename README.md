# RepAgent

## UA

### Ремонтне агенство

Існують ролі: *менеджер*, *майстер*, *користувач*.

**Зареєстрований користувач** може створювати заявку на ремонт. Також у **користувача** є рахунок, з якого здійснюється оплата за ремонт.

**Менеджер** має можливість управляти заявками користувача:

- призначити майстра
- визначити вартість робіт
- змінити статус заявки: *«чекає на оплату»*, *«сплачено»*, *«відмінено»*.

**Менеджер** також має можливість поповнити рахунок користувача.

**Майстер** має можливість вибрати із списка заявку на ремонт та змінити її статус на «в роботі» або «виконано».

Після того, як заявка була виконана, **користувач** має можливість лишити відгук щодо роботи майстра.

**Менеджер** повинен мати змогу подивитись звіт зі списком заявок, де він може *провети сортування*:
- по даті заявки
- статусу заявки
- по вартості.

Також **менеджер** повинен мати змогу *фільтрувати* замовлення:
- за статусом
- за майстром, що виконує/виконував замовлення



## ENG

### Repair agency

There are roles: *manager*, *master*, *user*.

**Registered user** can create a repair request. **user** also has an account from which payment for repairs is made.

**Manager** has the ability to manage user requests:

- appoint a master
- determine the cost of works
- change the application status: *«waiting for payment»*, *«paid»*, *«cancelled»*.

The **Manager** also has the ability to top up the user's account.

The **Master** can select a repair request from the list and change its status to «in progress» or «completed».

After the application has been completed, the **user** has the opportunity to leave feedback on the work of the wizard.

The **Manager** should be able to see a report with a list of applications where he can *sort*:
- by the date of the application
- application status
- by cost.

Also **manager** must be able to *filter* orders:
- by status
- according to the master who executes/executed the order
