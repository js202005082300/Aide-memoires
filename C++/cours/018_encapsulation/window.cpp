#include "window.hpp"
#include <iostream>
#include <string>

Window::Window(std::string title) : title(title)
{
}

std::string Window::getTitle() const
{
    return this->title;
}

void Window::setTitle(const std::string title)
{
    if(title.length() > 20)
        throw new std::invalid_argument("Le nom de la fenetre doit comporter 20 caracteres max");
        
    this->title = title;
}