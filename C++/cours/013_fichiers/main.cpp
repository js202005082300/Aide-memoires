#include <iostream>
#include <string>
#include <fstream>

void lecture_test(std::string file)
{
    std::ifstream f{file};

    if(f.is_open())
    {
        std::string line{" "};

        while(f) {
            std::getline(f >> std::ws, line);
            std::cout << line << std::endl;
        }
    }
}

int main()
{
    std::ifstream f{"animals.txt"}; //std::ios::in

    if(f.is_open())
    {
        std::string line{" "};

        std::getline(f >> std::ws, line);
        std::cout << line << std::endl;

        std::getline(f >> std::ws, line);
        std::cout << line << std::endl;
    }

    std::cout << std::endl;

    lecture_test("animals.txt");
    
    return 0;
}