# -*- coding: utf-8 -*-

class Perfil(object):
    'Classe para moldar perfis de usuarios'

    def __init__(self, nome, telefone, empresa):
        self.nome = nome
        self.telefone = telefone
        self.empresa = empresa

    def imprimir(self):
        print 'Perfil(nome=%s, telefone=%s, empresa=%s)' % (self.nome, self.telefone, self.empresa)

class Data(object):

    def __init__(self, dia, mes, ano):
        self.dia = dia
        self.mes = mes
        self.ano = ano

    def imprimir(self):
        print '%s/%s/%s' % (self.dia, self.mes, self.ano)


class Pessoa(object):

    def __init__(self, nome, peso, altura):
        self.nome = nome
        self.peso = float(peso)
        self.altura = float(altura)
        
    def imc(self):
        imc = (self.peso / (self.altura**2))
        print 'IMC de %s: %s' % (self.nome, imc)