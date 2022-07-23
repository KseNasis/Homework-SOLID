# ������ �������

## ��������

���������-�������, � ������� ������������ ���������� ������ � ����������� ��������� ��������� ���������� �����, DRY � �������� SOLID.
	����������� ���������:
* ����� ��������� ��� ������� �������.
* �������� ������������������ ������ �� ���-�� � ���� � ��������.
* ����������� ������� ������������
* ���������� ������� �� ���������, �����, ��������.
* ���������� ������� �� �����.
* ���������� ������� �� ��������.
* �������� �������� ������.
* �������� �� ���������� �� ���������� ������.
* ������ ��� ������� �������.
* �������� ������� � �������� �������.
* ������� ��������������� ������� ��� ������� �������. 			

> SOLID-��� ������������, ������� ���������� ���� ��������� ��� � ��������������.
>>        S-������� ������������ ���������������(Single Responsibility Principle)
>>                  ����� ������ ��������� ������ �� �������, ��� ������� �� ��������� ������������.
>>        O-������� ����������/����������(Open Closed Principle)
>>                  ����������� �������� ������ ���� ������� ��� ����������, �� ������� ��� �����������.
>>        L-������� ������ ������� ������ (Liskov Substitution Principle)
>>                  �������� ������ �����, ����� ������ ������ ���� �� ������.
>>        I-������� ����������(����������)����������(Interface Segregation Principle)
>>                  ����� �����������, ���������� ��������������� ��� ��������, �����, ��� ���� ��������� ������ ����������.
>>        D-������� �������� ������������(Dependency Inversion Principle)
>>                  �� ������� �� ����������(�����������), � �� �� ������� ���������� ���� �����.

## ������� ���������, �������������� � ����:
### Magic:
� ������ Main �� 146 ������ catalog.modifygetCatalog(). - ��������� �� ���������� ��������� � ������, � �� �� ������ ����� "9".
������ ������ �������� � ��������� ��������� discount.

###DRY:
������ printCatalog(), printBasket(), getProductsInBasket() ��������� �������� ������������ ����.
� ������ ������ � ���� ������������ ������ getProductByCode � printAllProducts �� ������ ShopUtils. ��� ������ �������� �������� ������������ ����

###SOLID
* ������� S - ������� ������������ ���������������. 
����� Cashbox �������� ������ �� ������ ��������� �������.
����� Basket �������� ������ �� ����������/�������� �������.
* ������� O - ������� ����������/����������.
��� ������ ����������� �� ������ Product, ������� �� ���������� � ������ �������. ��� ��������� ��������� ����� ������ � ����������� ����������, �� ����� �������� ����� Product � ������, ������� ��� ����������
* ������� L-������� ������ ������� ������.
��� ������ ����������� �� ������ Product � ����� ���� ������������ ������ ������-��������.
* ������� I- ������� ���������� (����������) ����������.
���������� Filter, Sort ���������. ��� �� ��������� ������ �������� notification � delivery ��� �� ������������� ����� �������. 
* ������� D- ������� �������� ������������.
���������� Notification � Delivery ������������ ���������� ������� ��������.
