
#### Build an MCP Server with Java

/assets/devoxxlogonewbaseline-1.svg
size: contain

---

## Sergio Del Amo Caballero
## Oracle Labs
## Micronaut Committer
## https://sergiodelamo.com  

---

# Demos repository
# [github.com/sdelamo/devoxxbe-2025-mcp-server](https://github.com/sdelamo/devoxxbe-2025-mcp-server)

----

# Weather tools 
## https://github.com/sdelamo/micronaut-mcp-tools-weather

----

# Micronaut Fun
## https://micronaut.fun/mcp
## https://github.com/micronaut-projects/micronaut-fun

---

# Deep Dive Agenda
## 09:30 - 10:45 Part 1
## 10:15 - 11:15 Break
## 11:15 - 12:30 Part 2

---

# Model Context Protocol (MCP)

----

## MCP is an open-source standard for connecting AI applications to external systems.
### https://modelcontextprotocol.io

---


/assets/mcp-simple-diagram.png
size: contain


---

## MCP provides a consistent interface, allowing models (clients) to integrate seamlessly with external tools and data providers (servers).

---

## 🚫 This eliminates the need for diverse, custom protocols for each API or data source.

--- 

#  Benefits of MCP

---

# Freshness
### Models can access up-to-date information beyond their training data

---

# Capability Extension
### Models can leverage specialized tools for tasks they weren't trained for

---

# Reduced Hallucinations
### External data sources provide factual grounding

---

# Privacy
### Sensitive data can stay within secure environments instead of being embedded in prompts

---

# Client - Server Architecture

---

# MCP Hosts
### The AI application that coordinates and manages one or multiple MCP clients

---

# MCP Clients
### A component that maintains a connection to an MCP server and obtains context from an MCP server for the MCP host to use

---

# MCP Servers
### A program that provides context, tools, and capabilities

---

# Two Layers:
## Transport Layer
## Data Layer

---

## Transport Layer
# STDIO Transport 
### Uses standard input/output streams for direct process communication between local processes on the same machine

----

## Transport Layer
# Streamable HTTP Transport
### Uses HTTP POST for client-to-server messages with optional Server-Sent Events for streaming capabilities. T

---
# Data Layer
## A JSON-RPC 2.0 based exchange protocol that defines the message structure and semantics. 

---

# MCP Servers Key Components

---

# Resources
## Static or dynamic data for models

---

# Prompts
## Predefined workflows for guided generation

---

# Tool
## Executable functions like search, calculations

---

# Tools
## Tools are model-controlled, meaning AI models can discover and invoke them automatically.

---

## Tools Safety
# Displaying available tools in the UI, enabling users to define whether a tool should be made available in specific interactions

---

## Tools Safety
# Approval dialogs for individual tool executions

---

## Tools Safety
# Permission settings for pre-approving certain safe operations

---

## Tools Safety
# Activity logs that show all tool executions with their results

---

# MCP Inspector

---

# Designed to work with any programming language

----

## Disk Space Stdio Transport Demo
# Java MPC SDK

---

# PING


---

## Disk Space Stdio Transport Demo
# Micronaut MPC

---

# GitHub Copilot MCP Server

---

## Disk Space Stdio Transport Demo
# Quarkus MPC

---

# Claude Desktop MCP Server

---

## Disk Space Stdio Transport Demo
# Spring Boot MPC

---

# VS Studio MCP Server

---

## Diskspace HTTP Transport Demo
# Java MPC SDK

---

## Diskspace HTTP Transport Demo
# Micronaut MPC

---

## Diskspace HTTP Transport Demo
# Quarkus MPC

---

## Diskspace HTTP Transport Demo
# Spring Boot MPC

---

# Tool Annotations

---

# Resource

---

# Resource Template

---

# Resource Completion

---

# Prompt

----

# Prompts Claude Code

---
# Classpath Prompts

----

## Chat GPT Tools
# Search / Fetch

---- 

# Testing

---- 

# Java SDK MCP Client

---- 

# Langchain4J MCP Client

---- 

# Postman MCP
#### https://learning.postman.com/docs/developer/postman-api/postman-mcp-server/set-up-postman-mcp-server/

----

# Security

----

# Streamable HTTP
## This transport supports standard HTTP authentication methods including bearer tokens, API keys, and custom headers. MCP recommends using OAuth to obtain authentication tokens.

----

# Notifications
#### The protocol supports real-time notifications to enable dynamic updates between servers and clients.

---

# Client capabilities

---

# Sampling
### Allows servers to request language model completions from the client’s AI application.

----

# Elicitation
### Allows servers to request additional information from users. 

---

# Logging
#### Enables servers to send log messages to clients for debugging and monitoring purposes.
