'''
Created on 06/12/2014

@author: elton
'''



import sys
from pulp import *

# Cria o problema
prob = LpProblem("Custo Minimo - Loja de Animais", LpMinimize)

# Cria as variaveis
x1 = LpVariable("Racao A", 0)
x2 = LpVariable("Racao B", 0)
x3 = LpVariable("Racao C", 0)
x4 = LpVariable("Racao D", 0)
x5 = LpVariable("Racao E", 0)
x6 = LpVariable("Racao F", 0)

# Cria a funcao objetivo
prob += 2 * x1 + 3 * x2 + 5 * x3 + 6 * x4 + 8 * x5 + 8 * x6, "Total custos"

# Restricoes
prob += 20 * x1 + 30 * x2 + 40 * x3 + 40 * x4 + 45 * x5 + 30 * x6 >= 70, "Proteinas requeridas"
prob += 50 * x1 + 30 * x2 + 20 * x3 + 25 * x4 + 50 * x5 + 20 * x6 >= 100, "Carboidratos requeridos"
prob += 4 * x1 + 9 * x2 + 11 * x3 + 10 * x4 + 9 * x5 + 10 * x6 >= 20, "Gorduras requeridas"

# Escreve o modelo no arquivo
prob.writeLP("RacaoModelo.lp")

# Resolve o problema
GLPK().solve(prob)

# Imprime o status da resolucao
print "Status:", LpStatus[prob.status]

# Solucoes otimas das variaveis
for variable in prob.variables():
   print "%s = %f" % (variable.name, variable.varValue)

# Objetivo otimizado
print "Custo Mínimo da mistura das racoes: R$ %0.2f" % value(prob.objective)