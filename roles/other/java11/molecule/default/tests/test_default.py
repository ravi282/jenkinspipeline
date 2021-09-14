"""Role testing files using testinfra."""


def test_java_version(host):
    command = host.run('java -version')
    assert command.rc == 0
    print(command.stdout)
    #assert command.stdout
