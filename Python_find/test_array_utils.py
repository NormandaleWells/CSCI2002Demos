
import array_utils

def test():
    a = [27, 82, 41, 124, 62, 31]
    if array_utils.find(a, 27) != 0:
        print('test 1 failed')
    if array_utils.find(a, 31) != 5:
        print('test 2 failed')
    if array_utils.find(a, 41) != 2:
        print('test 3 failed')
    if array_utils.find(a, 42) != -1:
        print('test 4 failed')

    s = ['jane', 'elizabeth', 'mary', 'kitty', 'lydia']
    if array_utils.find(s, 'jane') != 0:
        print('test 5 failed')
    if array_utils.find(s, 'lydia') != 4:
        print('test 6 failed')
    if array_utils.find(s, 'mary') != 2:
        print('test 7 failed')
    if array_utils.find(s, 'darcy') != -1:
        print('test 8 failed')


if __name__ == '__main__':
    test()
