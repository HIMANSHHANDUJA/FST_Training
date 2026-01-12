import pytest

def addition():
    a=2
    b=8
    sum=a+b
    assert sum==10

def test_subtraction(): 
    a=8
    b=2
    diff=a-b
    assert diff==6

@pytest.mark.activity
def multiplication(): 
    a=8
    b=2
    mul=a-b
    assert mul==6

@pytest.mark.activity
def division(): 
    a=8
    b=2
    div=a-b
    assert div == a / b==6


