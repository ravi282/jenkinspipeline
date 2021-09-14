ZOOKEEPER
=========

This role is for configure zookeeper .

Requirements
------------

we need to update the zookeeper ip or list of ips in startup.csv file in properties folder.

Role Variables
--------------

we need to setup a varible env in defaults main.yml or we can parse the varible while running the playbook.
ex: ansible-playbook -i inventory/develop/devlop-infra zoo.yml --tags "common,zoo-setup,zoo-start" --extra-vars "env=develop"

Dependencies
------------

before running this role we need to run the common role.

Example Playbook
----------------

Including an example of how to use your role (for instance, with variables passed in as parameters) is always nice for users too:

    - hosts: zookeeper
      roles:
         - common
         - zookeeper

License
-------

BSD

Author Information
------------------

An optional section for the role authors to include contact information, or a website (HTML is not allowed).
