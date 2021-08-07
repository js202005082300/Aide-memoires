#coding:utf-8

PI = 3.14

def square_perimeter(side):
    return 4 * side

def square_area(side):
    return side * side

def cube_volume(side):
    return side * side * side

def circle_perimeter(radius):
    return 2 * PI * radius

def circle_area(radius):
    return PI * radius**2 # ** : opérateur de puissance (radius * radius).

def sphere_volume(radius):
    return 4 * PI * radius**3 / 3

if __name__ == '__main__':
    print("Périmètre carré : {}".format(square_perimeter(10)))
    print("Aire carré : {}".format(square_area(10)))
    print("Volume cube : {}".format(cube_volume(10)))

    print("Périmètre du cercle : %.2f" % circle_perimeter(5))
    print("Aire du cercle : %.2f" % circle_area(5))
    print("Volume sphère : %.2f" % sphere_volume(5))