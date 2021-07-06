#if !defined(__HUMAN__)
#define __HUMAN__

    #include <string>

    class Human
    {
        public:
            Human();
            Human(std::string name, int age);
            Human(const Human &other);

            std::string getName() const;
            void setName(const std::string name);

            void hello();

        private:
            std::string mName;
            int mAge;
    };

#endif