// Hello.h

#if defined(_WIN32) && defined(DLL_EXPORT)
#define LIB_FUNC __declspec(dllimport)
#else
#define LIB_FUNC
#endif

class __declspec(dllexport) Hello
{
    private:
        const char * who;
    public:
        Hello(const char * who);
        void sayHello(unsigned n = 1);
};