import os
import xlwt

a = os.getcwd()
print(a)
os.chdir('F:\华师\Android\Cantonese-Learning')
a = os.getcwd()
print(a)

# with open('cidian_zhyue-jt-kfcd-ylshu-2019623.txt', 'r',encoding='utf-8') as raw:
#     for line in raw:
#         print(line)

book = xlwt.Workbook(encoding='utf-8', style_compression=0)
sheet = book.add_sheet('output', cell_overwrite_ok=True)
sheet.write(0, 0, 'word')
sheet.write(0, 1, 'pronunciation')
sheet.write(0, 2, 'meaning')

n = 1
with open('cidian_zhyue-jt-kfcd-ylshu-2019623.txt', 'r+',encoding='utf-8') as fd:
    for text in fd.readlines():
        a = text.split('\t')[0]
        b = text.split('\t')[1]
        c = text.split('\t')[2]
        print(a)
        print(b)
        print(c)
        sheet.write(n, 0, a)
        sheet.write(n, 1, b)
        sheet.write(n, 2, c)
        n = n + 1

book.save('output.xls')