#include "window.hpp"
#include <iostream>
#include <string>

Window::Window(std::string t) : title(t)
{
    // this->title = title;
}

void Window::run() const noexcept
{
    std::cout << "Affichage..." << std::endl;
}