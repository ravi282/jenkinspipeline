Elastic Search
=========

This role is to configure elastic search cluster for taxilla platform.

Requirements
------------

It requires ec2 instance r5.2xlarge.

Role Variables
--------------

**cluster_name:** Cluster name for elastic search cluster.<br />**data_folder_path:** Data folder path for elastic search data.<br />**user:** The user name for elastic search process to run.<br />**master:** if the node is master this variable should be true and the variable should be defined under host varibles.


Dependencies
------------

By default it will execute the **common** role.

Example Playbook
----------------

    - hosts: elastic-search
      become: yes
      vars:
        cluster_name: taxilla
        data_folder_path: /var/elastic-search/
        user: taxadmin
      roles:
         - elastic-search


