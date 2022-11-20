#ifndef __WINDOW__
    #define __WINDOW__
    #include <string>

    class Window
    {
        public:
            Window(std::string title);
            std::string getTitle() const;
            void setTitle(const std::string title);
        private:
            std::string title;
    };

#endif