#include <iostream>
#include <string>

int main()
{
    std::string sentence{"Hello world, how are you?"};

    for(const auto letter : sentence) // pour chaque "letter" de "sentence"
    {
        std::cout << letter << "\n";
    }
    
    return 0;
}