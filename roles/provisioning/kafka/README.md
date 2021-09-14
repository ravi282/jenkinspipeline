Kafka
=========

This role is to setup kafka cluster from scratch.

Requirements
------------

we need an ec2 instance.

Role Variables
--------------

**user:** username for kafka process needs to run.<br />
**kafka_data_folder:** kafka data folder path.<br />
**heap_memory:** heap memoy of kafka server.default value is 6GB

Dependencies
------------

A list of other roles hosted on Galaxy should go here, plus any details in regards to parameters that may need to be set for other roles, or variables that are used from other roles.

Example Playbook
----------------

Including an example of how to use your role (for instance, with variables passed in as parameters) is always nice for users too:

    - hosts: servers
      roles:
         - { role: username.rolename, x: 42 }

License
-------

BSD

Author Information
------------------

An optional section for the role authors to include contact information, or a website (HTML is not allowed).
