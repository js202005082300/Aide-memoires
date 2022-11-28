#ifndef __ENGLISH___
    #define __ENGLISH___
    #include "someone.hpp"
    #include <string>

    class English : public Someone
    {
        using Someone::Someone;

        public:
            void sayGoodNight() const noexcept override; // override.
    };

#endif