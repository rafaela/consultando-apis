#coding: utf-8
import urllib2
import json

url = 'https://api.github.com/users/rafaela/repos?type=owner'
consulta = json.loads(urllib2.urlopen(url).read())

usuario = consulta[0]['owner']['login']

print 'Usuário da Consulta:', usuario

urlSeguidores = consulta[0]['owner']['followers_url']

consultaSeguidores = json.loads(urllib2.urlopen(urlSeguidores).read())

print len(consultaSeguidores), 'seguidores\n'

for seguidor in consultaSeguidores:
    print seguidor['login']
    urlRepoSeguidores = seguidor['repos_url']
    repoSeguidores = json.loads(urllib2.urlopen(urlRepoSeguidores).read())
    for nomeRepo in repoSeguidores:
        print '\t', nomeRepo['name']


