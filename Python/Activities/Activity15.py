def nameError():
    try:
        print(x)
    except NameError:
        print(f"The x not defined")

nameError()
