# -*- coding: UTF-8 -*-
#arquivo app.py
#teste de acentos: á

import re

def cadastrar(nomes):
    print 'Digite: o nome:'
    nome = raw_input()
    nomes.append(nome)

def listar(nomes):
    print 'Listando nomes:'
    for nome in nomes:
        print nome

def remover(nomes):
    print 'Qual nome você gostaria de remover?'
    escolha = raw_input()
    nomes.remove(escolha)

def alterar(nomes):

    print 'Qual nome vc gostaria de alterar?'
    escolha = raw_input()

    if(escolha in nomes):
        index = nomes.index(escolha)
        print 'Qual é o novo nome?'
        escolha = raw_input()
        nomes[index] = escolha

def procurar(nomes):
    print 'Digite nome a procurar:'
    nome_a_procurar = raw_input()
    if(nome_a_procurar in nomes):
        print 'O nome %s existe' % nome_a_procurar
    else:
        print 'O nome %s não existe' % nome_a_procurar

def procurar_regex(nomes):

    print('Digite a expressão regular')
    regex = raw_input()
    nomes_texto = ' '.join(nomes);
    resultado = re.findall(regex+'\w+', nomes_texto)
    print resultado
    

def menu():
    nomes = [] #nao podemos esquecer de inicializar a lista
    escolha = ''
    while(escolha != '0'):    
        print 'Digite:'
        print '0 para terminar;'
        print '1 para cadastrar;'
        print '2 para listar;'
        print '3 para remover;'
        print '4 para alterar;'
        print '5 para pesquisar;'
        print '6 para pesquisar;'

        escolha = raw_input()

        if(escolha == '1'):
            cadastrar(nomes)

        if(escolha == '2'):
            listar(nomes)

        if(escolha == '3'):
            remover(nomes)

        if(escolha == '4'):
            alterar(nomes)

        if(escolha == '5'):
            procurar(nomes)

        if(escolha == '6'):
            procurar_regex(nomes)
menu();